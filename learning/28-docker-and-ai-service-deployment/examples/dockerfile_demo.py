dockerfile_steps = [
    "FROM python:3.12-slim",
    "WORKDIR /app",
    "COPY requirements.txt ./",
    "RUN pip install -r requirements.txt",
    "COPY . .",
    'CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]',
]


def show_dockerfile():
    print("一个最小 Dockerfile 直觉:")
    for step in dockerfile_steps:
        print(step)


if __name__ == "__main__":
    show_dockerfile()
