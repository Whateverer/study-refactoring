# study-refactoring
인프런 코딩으로 학습하는 리팩토링 강의 정리
# 섹션0. 소개
## 강의소개
### 리팩토링 (Refactoring)
소프트웨어는 계속 변하기 때문에
- 처음부터 완벽하게 시스템을 설계하는 것은 매우 어려운 일이다.
- 이미 코드를 작성한 이후에 구조를 변경하는 일이 발생한다.
- 리팩토링으로 애플리케이션 구조를 꾸준히 개선해 나가야 한다.
- 구조 변경으로 인한 버그를 줄이면서 코드를 깔끔하게 유지할 수 있는 방법이다.

# 섹션1. 이해하기 힘든 이름
## 냄새1. 이해하기 힘든 이름
Mysterius Name
- 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 "좋은 이름"이다.
- 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이어야 한다.
- 사용할 수 있는 리팩토링 기술
  - 함수 선언 변경하기 (Change Function Declaration)
  - 변수 이름 바꾸기 (Rename Variable)
  - 필드 이름 바꾸기 (Rename Field)

## 리팩토링1. 함수 선언 변경하기
Change Function Declaration     
함수 이름 변경하기, 메소드 이름 변경하기, 매개변수 추가하기, 매개변수 제거하기, 시그니처 변경하기
- 좋은 이름을 가진 함수는 함수가 어떻게 구현되었는지 코드를 보지 않아도 이름만 보고도 이해할 수 있다.
- 좋은 이름을 찾아내는 방법? 함수에 주석을 작성한 다음, 주석을 함수 이름으로 만들어 본다.
- 함수의 매개변수는
  - 함수 내부의 문맥을 결정한다. (예, 전화번호 포매팅 함수)
  - 의존성을 결정한다. (예, Payment 만기일 계산 함수)

## 리팩토링2. 변수 이름 바꾸기
Rename Variable
- 더 많이 사용되는 변수일수록 그 이름이 더 중요하다.
  - 람다식에서 사용한느 변수 vs 함수의 매개변수
- 다이나믹 타입을 지원하는 언어에서는 타입을 이름에 넣기도 한다.
- 여러 함수에 걸쳐 쓰이는 필드 이름에는 더 많이 고민하고 이름을 짓는다.

## 리팩토링 3. 필드 이름 바꾸기
Rename Field
- Record 자료 구조의 필드 이름은 프로그램 전반에 걸쳐 참조될 수 있기 때문에 매우 중요하다.
- Record 자료 구조 : 특정 데이터와 관련있는 필드를 묶어놓은 자료 구조
- 파이썬의 Dictionary, 또는 줄여서 dicts.
- C#의 Record.
- 자바 14버전부터 지원.(record 키워드)
- 자바에서는 Getter와 Setter 메소드 이름도 필드의 이름과 비슷하게 간주할 수 있다.

# 섹션2. 중복 코드
## 냄새2. 중복 코드
Duplicated Code
- 중복 코드의 단점
  - 비슷한지, 완전히 동일한 코드인지 주의 깊게 봐야한다.
  - 코드를 변경할 때, 동일한 모든 곳의 코드를 변경해야 한다.
- 사용할 수 있는 리팩토링 기술
  - 동일한 코드를 여러 메소드에서 사용하는 경우. 함수 추출하기(Extract Function)
  - 코드가 비슷하게 생겼지만 완전히 같지는 않은 경우, 코드 분리하기(Slide Statements)
  - 여러 하위 클래스에 동일한 코드가 있다면, 메소드 올리기(Pull Up Method)

## 리팩토링4. 함수 추출하기
Extract Function
- "의도"와 "구현" 분리하기
- 무슨 일을 하는 코드인지 알아내려고 노력해야 하는 코드라면 해당 코드를 함수로 분리하고 함수 이름으로 "무슨 일을 하는지" 표현할 수 있다.
- 한줄 짜리 메소드도 괜찮은가? (괜찮다. 의도를 잘 드러낼 수 있다면)
- 거대한 함수 안에 들어있는 주석은 추출한 함수를 찾는데 있어서 좋은 단서가 될 수 있다.

## 리팩토링5. 코드 정리하기
Slide Statements
- 관련있는 코드끼리 묶여있어야 코드를 더 쉽게 이해할 수 있다.
- 함수에서 사용할 변수를 상단에 미리 정의하기 보다는, 해당 변수를 사용하는 코드 바로 위에 선언하자.
- 관련있는 코드끼리 묶은 다음, 함수 추출하기(Extract Function)을 사용해서 더 깔끔하게 분리할 수도 있다.

# 섹션3. 긴 함수
# 섹션4. 긴 매개변수 목록
# 섹션5. 전역 데이터
# 섹션6. 가변 데이터
# 섹션7. 뒤엉킨 변경
# 섹션8. 산탄총 수술
# 섹션9. 기능 편애
# 섹션10. 데이터 뭉치
# 섹션11. 기본형 집착
# 섹션12. 반복되는 switch문
# 섹션13. 반복문
# 섹션14. 성의없는 요소
# 섹션15. 추측성 일반화
# 섹션16. 임시 필드
# 섹션17. 메시지 체인
# 섹션18. 중재자
# 섹션19. 내부자 거래
# 섹션20. 거대한 클래스
# 섹션21. 서로 다른 인터페이스의 대안 클래스들
# 섹션22. 데이터 클래스
# 섹션23. 상속 포기
# 섹션24. 주석
# 섹션25. 리팩토링 카탈로그

