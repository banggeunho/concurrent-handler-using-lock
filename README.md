# concurrent-handler-using-lock

## Spring boot, MySQL, Redis를 사용하여 동시성 문제 처리하기

1. Pessimistic Lock (비관적 락) 적용 (X-LOCK, row 단위)
2. Optimistic Lock (낙관적 락) 적용 (without DB, row 단위)
3. Named Lock (네임드 락) 적용 (metadata, key 단위) - 별도의 테이블, 데이터소스에 적용
4. Distributed Lock (분산 락) 적용 (redis 이용) - 분산저장소에 Lock을 저장함으로서 DB 부하 방지
