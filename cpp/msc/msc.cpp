#include <iostream>
#include <exception>
#include <math.h>
#include <chrono>
#include <thread>
#define PI 3.14159265

using namespace std;

struct Location
{
	double X;
	double Y;

	Location() : X(0), Y(0) {}

	Location(double x, double y) { X = x; Y = y; }

	Location(const Location& other)
	{
		X = other.X;
		Y = other.Y;
	}

	Location& Location::operator = (const Location& rhs)
	{
		X = rhs.X;
		Y = rhs.Y;
		return *this;
	}
};


class Vechicle
{
public:

	virtual ~Vechicle() {}
	virtual void Start() = 0;
	virtual void SetDestination(Location& dest) = 0;
	virtual void Drive() = 0;
	virtual void Stop() = 0;
	virtual bool IsDriving() = 0;
	virtual const Location& GetLocation() = 0;
};

class Car : public Vechicle
{
public:

	Car() : m_isDriving(false), m_isStarted(false)
	{
		m_milesPerEpoch = (double)s_speed / (60 * 60 * 100);
	}

	virtual ~Car() {}

	// Inherited via Vechicle
	virtual void Start() override
	{
		m_isStarted = true;
	}

	virtual void SetDestination(Location& dest) override
	{
		m_dest = dest;
	}

	virtual void Drive() override
	{
		if (!m_isStarted)
		{
			throw std::exception("Car needs to be started before driving");
		}
		
		m_isDriving = true;
		m_location = m_start;

		double xDiff = abs(m_dest.X - m_start.X);
		double yDiff = abs(m_dest.Y - m_start.Y);
		
		double angle = 0;
		if (xDiff != 0)
		{
			angle = atan(yDiff / xDiff) * 180 / PI;
		}
		
		double xMilesPerEpoch = m_milesPerEpoch * sin(angle);
		double yMilesPerEpoch = m_milesPerEpoch * cos(angle);


		while (true)
		{			
			std::this_thread::sleep_for(std::chrono::milliseconds(s_epoch));
			
			if (m_dest.X >= m_start.X)
			{
				m_location.X = m_location.X + xMilesPerEpoch;
			}
			else
			{
				m_location.X = m_location.X - xMilesPerEpoch;
			}

			if (m_dest.Y >= m_start.Y)
			{
				m_location.Y = m_location.Y + yMilesPerEpoch;
			}
			else
			{
				m_location.Y = m_location.Y - yMilesPerEpoch;
			}

			if (m_location.X >= m_dest.X)
			{
				break;
			}
		}

		m_isDriving = false;
	}

	virtual void Stop() override
	{
		m_isDriving = false;
		m_isStarted = false;
	}

	virtual bool IsDriving() override
	{
		return m_isStarted && m_isDriving;
	}

	virtual const Location& GetLocation() override
	{
		return m_location;
	}

private:
	Location m_location;
	Location m_dest;
	Location m_start;
	bool     m_isDriving;
	bool	 m_isStarted;
	double	 m_milesPerEpoch;

	const int s_speed = 180; // 10 miles per hour
	const int s_epoch = 10;  // 10 millisecond

};


int main(int argc, char* argv[])
{

	Vechicle* car = new Car();
	Location dest(1, 1);
	car->SetDestination(dest);
	car->Start();
	std::thread t1([&]() { car->Drive();});
	std::thread t2([&]() { 
		while (car->IsDriving())
		{
			Location loc = car->GetLocation();
			cout << "["<< loc.X << "," << loc.Y << "]"<<endl;
			std::this_thread::sleep_for(std::chrono::milliseconds(1000));
		}
		});
	t1.join();
	t2.join();
	car->Stop();

	cout << "Hello" << endl;
	int x;
	cin >> x;
	return 0;
}

