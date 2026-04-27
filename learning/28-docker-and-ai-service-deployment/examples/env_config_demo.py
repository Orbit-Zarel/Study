import os


def load_runtime_config():
    config = {
        "OPENAI_API_KEY": os.getenv("OPENAI_API_KEY", "<missing>"),
        "REDIS_URL": os.getenv("REDIS_URL", "redis://localhost:6379"),
        "POSTGRES_URL": os.getenv("POSTGRES_URL", "<missing>"),
    }

    print("运行时配置:")
    for key, value in config.items():
        print(f"{key} = {value}")


if __name__ == "__main__":
    load_runtime_config()
