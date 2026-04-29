def guardrail_check(input_tokens: int, user_quota: int):
    if input_tokens > 8000:
        return "reject: input too long"
    if user_quota <= 0:
        return "reject: no quota"
    return "allow"


if __name__ == "__main__":
    print(guardrail_check(3000, 10))
    print(guardrail_check(12000, 10))
    print(guardrail_check(3000, 0))
