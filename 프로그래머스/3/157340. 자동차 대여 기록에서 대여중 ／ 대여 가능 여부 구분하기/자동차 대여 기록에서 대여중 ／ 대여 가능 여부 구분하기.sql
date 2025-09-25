-- 코드를 입력하세요


SELECT car_id,
    CASE 
        WHEN car_id IN (SELECT car_id
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
                       ) THEN '대여중'
        ELSE '대여 가능'
        END AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY car_id
ORDER BY car_id desc;