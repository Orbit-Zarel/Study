documents = [
    {"id": "doc-1", "company": "CATL", "year": 2025, "report_type": "earnings_call"},
    {"id": "doc-2", "company": "BYD", "year": 2025, "report_type": "research_note"},
    {"id": "doc-3", "company": "CATL", "year": 2024, "report_type": "earnings_call"},
]


def filter_documents(company: str, year: int, report_type: str):
    print(f"filter 条件: company={company}, year={year}, report_type={report_type}")
    results = [
        doc for doc in documents
        if doc["company"] == company
        and doc["year"] == year
        and doc["report_type"] == report_type
    ]

    print("命中的文档:")
    for item in results:
        print(item)


if __name__ == "__main__":
    filter_documents("CATL", 2025, "earnings_call")
