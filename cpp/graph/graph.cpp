// graph.cpp : Defines the entry point for the console application.
//
#include <iostream>
#include <memory>
#include <thread>
#include <chrono>
#include <mutex>
/*
struct Base
{
	Base() { std::cout << "  Base::Base()\n"; }
	// Note: non-virtual destructor is OK here
	~Base() { std::cout << "  Base::~Base()\n"; }
};

struct Derived : public Base
{
	Derived() { std::cout << "  Derived::Derived()\n"; }
	~Derived() { std::cout << "  Derived::~Derived()\n"; }
};

void thr(std::shared_ptr<Base> p)
{
	std::this_thread::sleep_for(std::chrono::seconds(1));
	std::shared_ptr<Base> lp = p; // thread-safe, even though the
								  // shared use_count is incremented
	
	{
		static std::mutex io_mutex;
		std::lock_guard<std::mutex> lk(io_mutex);
		std::cout << "local pointer in a thread:\n"
			<< "  lp.get() = " << lp.get()
			<< ", lp.use_count() = " << lp.use_count() << '\n';
	}
}

int main()
{
	std::shared_ptr<Base> p = std::make_shared<Derived>();

	std::cout << "Created a shared Derived (as a pointer to Base)\n"
		<< "  p.get() = " << p.get()
		<< ", p.use_count() = " << p.use_count() << '\n';
	std::thread t1(thr, p), t2(thr, p), t3(thr, p);
	p.reset(); // release ownership from main
	std::cout << "Shared ownership between 3 threads and released\n"
		<< "ownership from main:\n"
		<< "  p.get() = " << p.get()
		<< ", p.use_count() = " << p.use_count() << '\n';
	t1.join(); t2.join(); t3.join();
	std::cout << "All threads completed, the last one deleted Derived\n";

	int x;
	std::cin >> x;
	return 0;
}
*/

class Base
{
public:
	Base() 
	{
		std::cout << "Base()" << std::endl;
	}

	~Base()
	{
		std::cout << "~Base()" << std::endl;
	}
};

class Derived : public Base
{
public:
	Derived()
	{
		std::cout << "Derived()" << std::endl;
	}

	~Derived()
	{
		std::cout << "~Derived()" << std::endl;
	}
};


class ThreadWorker
{

protected:

	std::mutex m_guard;

	void ThreadFunction(std::shared_ptr<Base> bp)
	{
		std::this_thread::sleep_for(std::chrono::seconds(1));
		std::cout << "Got the shared pointer" << std::endl;
		{
			std::lock_guard<std::mutex> lg(m_guard);
			std::cout << "Internal pointer" << bp.get() << std::endl;
			std::cout << "Internal pointer counter" << bp.use_count() << std::endl;
		}
	}

public:

	void CallThreadsWithSharedPointers()
	{
		std::shared_ptr<Base> dp = std::make_shared<Derived>();

		std::thread th1(&ThreadWorker::ThreadFunction, this, dp);
		std::thread th2(&ThreadWorker::ThreadFunction, this, dp);
		std::thread th3(&ThreadWorker::ThreadFunction, this, dp);

		th1.join();
		th2.join();
		th3.join();		
	}
};


int main()
{
	ThreadWorker tw;
	tw.CallThreadsWithSharedPointers();	

	int x;
	std::cin >> x;
	return 0;
}





