#include <iostream>
#include <exception>
#include <math.h>
#include <chrono>
#include <thread>
#include <vector>
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

class PrimeNumbers
{
public:
	vector<int> GetPrimeNumbers(int numPrimes)
	{
		vector<int> primes;
		bool isPrime = true;
		for (int i = 0; i < numPrimes; ++i)
		{
			isPrime = true;
			for (int j = 2; j < i; ++j)
			{
				if (i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if (isPrime)
			{
				primes.push_back(i);
			}
		}
		return primes;
	}
};

void PrimeNumberTest()
{
	int count = 1000000;
	PrimeNumbers pn;
	vector<int> primes = pn.GetPrimeNumbers(count);
	int i = 0;

	for (auto ite = primes.begin(); ite != primes.end(); ++ite)
	{
		cout << i++ << "," << *ite << endl;
	}

	cout << primes.size() << "," << primes[primes.size() - 1] << endl;
};


void Cars()
{
	/*
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
	*/
}

class Node
{
public:
	Node() 
	{
		cout << "Node is called" << endl;
	}

	Node(const Node& other)
	{
		value = other.value;
		cout << "Node Copy is called" << endl;
	}

	const Node& operator=(const Node& other)
	{
		value = other.value;
		cout << "Node assignment is called" << endl;
		return *this;
	}

	Node(int v) : value(v) {}	
	int value;
};

void ArrayTest()
{
	int a[10];
	a[0] = 100;

	cout << "Calling Node b[10]" << endl << endl;
	Node b[10];
	b[0].value = 100;

	cout << "Calling new Node b[10]" << endl << endl;
	Node* c = new Node[10];
	c[0].value = 5000;
	c[2] =  Node(250);
	(c + 3)->value = 600;

	cout << "Calling vector<Node> v(5)" << endl << endl;
	vector<Node> v(5);
	v[0].value = 10;
	
	vector<Node> vv;
	vv.push_back(Node(1000));

}

int main(int argc, char* argv[])
{

	//Cars();
	//PrimeNumberTest();

	ArrayTest();

	cout << "Hello" << endl;
	int x;
	cin >> x;
	return 0;
}

