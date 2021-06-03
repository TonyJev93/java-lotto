# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항
1. 손님
   - 로또 구입금액을 입력 -> 구매정보 반환
   - 구매정보
      - 입력 유효성 검증 (예외처리)
        - 양수 여부
        - 1,000원 단위 여부
      - 구입한 로또 개수 출력
        - 로또 개수 = 입력금액/1000
1. 로또 기계
   - 로또 번호 섞기
   - 입력한 개수만큼 로또를 생성 -> 로또 리스트 반환
      - 입력 유효성 검증 (예외처리)
         - 양수 여부
1. 로또
   - 로또 번호 목록(6개) 보유
   - 당첨 결과 보유
     - 일치하는 로또 번호 개수 확인
     - 당첨 금액
   - 생성된 로또 번호 유효성 검증 (예외처리)
      - 중복 숫자 존재 여부
      - 6개의 숫자 생성 여부
1. 로또 번호
   - 유효성 검증
      - 1 ~ 45 사이의 숫자 여부
1. 지난 주 당첨 로또 = UI 로직 (사용자 입력)
    - 지난 주 당첨 로또 번호를 6자리 입력한다. -> 당첨 로또 반환
    - 입력 유효성 검증 (예외처리)
        - 6자리 입력 여부
        - 1~45 사이 숫자 입력 여부
        - 숫자 외 문자 입력 존재여부
        - 중복 숫자 입력 여부
1. 로또 리스트
    - 로또 목록을 소유
    - 당첨 금액을 계산한다. -> 당첨 결과 반환
        - 당첨 통계
        - 수익률 = 당첨금액/구매금액
    