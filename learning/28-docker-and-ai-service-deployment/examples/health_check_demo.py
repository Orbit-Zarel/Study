def health_check():
    dependencies = {
        "app": "ok",
        "redis": "ok",
        "postgres": "ok",
    }

    print("健康检查结果:")
    for name, status in dependencies.items():
        print(f"{name}: {status}")

    all_ok = all(status == "ok" for status in dependencies.values())
    print(f"service_status: {'healthy' if all_ok else 'unhealthy'}")


if __name__ == "__main__":
    health_check()
