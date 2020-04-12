import asyncio

db = []

async def print_after_sec(message):
    await asyncio.sleep(1)
    db.append(message)

async def main():
    task1 = asyncio.create_task(print_after_sec('hello world! 1'))
    task2 = asyncio.create_task(print_after_sec('hello world! 2'))
    await asyncio.gather(task1, task2)
    print(db)

if __name__ == '__main__':
    asyncio.run(main())
