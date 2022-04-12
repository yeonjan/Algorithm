def solution(phone_book):
    phone_book.sort()
    check="s"
    for p in phone_book:
        if p.find(check) == 0:
            return False
        check=p
    return True