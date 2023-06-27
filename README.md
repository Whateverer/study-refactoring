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

## 리팩토링6. 메소드 올리기
Pull up Method
- 중복 코드는 당장은 잘 동작하더라도 미래에 버그를 만들어 낼 빌미를 제공한다.
  - 예) A에서 코드를 고치고, B에는 반영하지 않은 경우
- 여러 하위 클래스에 동일한 코드가 있다면, 손쉽게 이 방법을 적용할 수 있다.
- 비슷하지만 일부 값만 다른 경우라면, "함수 매개변수화하기" 리팩토링을 적용한 이후에, 이 방법을 사용할 수 있다.
- 하위 클래스에 있는 코드가 상위 클래스가 아닌 하위 클래스 기능에 의존하고 있다면 "필드 올리기"를 적용한 이후에 이 방법을 적용할 수 있다.
- 두 메소드가 비슷한 절차를 따르고 있다면, "템플릿 메소드 패턴" 적용을 고려할 수 있다.

# 섹션3. 긴 함수
## 냄새3. 긴 함수
Long Function
- 짧은 함수 vs 긴 함수
  - 함수가 길 수록 더 이해가 어렵다. vs 짦은 함수는 더 많은 문맥 전환을 필요로 한다.
  - "과거에는" 작은 함수를 사용하는 경우에 더 많은 서브루틴 호출로 인한 오버헤드가 있었다.
  - 작은 함수에 "좋은 이름"을 사용했다면 해당 함수의 코드를 보지 않고도 이해할 수 있다.
  - 어떤 코드에 "주석"을 남기고 싶다면, 주석 대신 함수를 만들고 함수의 이름으로 "의도"를 표현해보자.
- 사용할 수 있는 리팩토링 기술
  - 99%는 "함수 추출하기(Extract Function)"로 해결할 수 있다.
  - 함수로 분리하면서 해당 함수로 전달해야 할 매개변수가 많아진다면 다음과 같은 리팩토링을 고려해볼 수 있다.
    - 임시 변수를 질의 함수로 바꾸기(Replace Temp with Query)
    - 매개 변수 객체 만들기(Introduce Parameter Object)
    - 객체 통째로 넘기기(Preserve Whole Object)
  - "조건문 분해하기(Decompose Conditional)"를 사용해 조건문을 분리할 수 있다.
  - 같은 조건으로 여러개의 switch문이 있다면, "조건문을 다형성으로 바꾸기(Replace Conditional with Polymorphism)"을 사용할 수 있다.
  - 반복문 안에서 여러 작업을 하고 있어서 하나의 메소드로 추출하기 어렵다면, "반복문 쪼개기(Split Loop)"를 적용할 수 있다.

## 리팩토링7. 임시 변수를 질의 함수로 바꾸기
Replace Temp with Query
- 변수를 사용하면 반복해서 동일한 식을 계산하는 것을 피할 수 있고, 이름을 사용해 의미를 표현할 수도 있다.
- 긴 함수를 리팩토링할 때, 그러한 임시 변수를 함수로 추출하여 분리한다면 빼낸 함수로 전달해야 할 매개변수를 줄일 수 있다.

## 리팩토링8. 매개변수 객체 만들기
Introduce Parameter Object
- 같은 매개변수들이 여러 메소드에 걸쳐 나타난다면 그 매개변수들을 묶은 자료구조를 만들 수 있다.
- 그렇게 만든 자료구조는 : 
  - 해당 데이터 간의 관계를 보다 명시적으로 나타낼 수 있다.
  - 함수에 전달할 매개변수 개수를 줄일 수 있다.
  - 도메인을 이해하는데 중요한 역할을 하는 클래스로 발전할 수도 있다.

## 리팩토링9. 객체 통째로 넘기기
Preserve Whole Object
- 어떤 한 레코드에서 구할 수 있는 여러 값들을 함수에 전달하는 경우, 해당 매개변수를 레코드 하나로 교체할 수 있다.
- 매개변수 목록을 줄일 수 있다. (향후에 추가할지도 모를 매개변수까지도..)
- 이 기술을 적용하기 전에 의존성을 고려해야 한다.
- 어쩌면 해당 메소드의 위치가 적절하지 않을 수도 있다. (기능 편애 "Feature Envy" 냄새에 해당한다.)

## 리팩토링10. 함수를 명령으로 바꾸기
Replace Function with Command
- 함수를 독립적인 객체인 Command로 만들어 사용할 수 있다.
- 커맨드 패턴을 적용하면 다음과 같은 장접을 만들 수도 있다.
  - 부가적인 기능으로 undo 기능을 만들 수도 있다.
  - 더 복잡한 기능을 구현하는데 필요한 여러 메소드를 추가할 수 있다.
  - 상속이나 템플릿을 활용할 수도 있다.
  - 복잡한 메소드를 여러 메소드나 필드를 활용해 쪼갤 수도 있다.
- 대부분의 경우에 "커맨드"보다는 "함수"를 사용하지만, 커맨드 말고 다른 방법이 없는 경우에만 사용한다.

## 리팩토링11. 조건문 분해하기
Decompose Conditional
- 여러 조건에 따라 달라지는 코드를 작성하다보면 종종 긴 함수가 만들어지는 것을 목격할 수 있다.
- "조건"과 "액션" 모두 "의도"를 표현해야 한다.
- 기술적으로는 "함수 추출하기"와 동일한 리팩토링이지만 의도만 다를 뿐이다.

## 리팩토링12. 반복문 쪼개기
Split Loop
- 하나의 반복문에서 여러 다른 작업을 하는 코드를 쉽게 찾아볼 수 있다.
- 해당 반복문을 수정할 때 여러 작업을 모두 고려하며 코딩을 해야한다.
- 반복문을 여러개로 쪼개면 보다 쉽게 이해하고 수정할 수 있다.
- 성능 문제를 야기할 수 있지만, "리팩토링"은 "성능 최적화"와 별개의 작업이다. 리팩토링을 마친 이후에 성능 최적화 시도할 수 있다.

## 리팩토링13. 조건문을 다형성으로 바꾸기
Replace Conditional with Polymorphism
- 여러 타입에 따라 각기 다른 로직으로 처리해야 하는 경우에 다형성을 적용해서 조건문보다 명확하게 분리할 수 있다.(예, 챌, 음악, 음식 등) 반복되는 switch문을 각기 다른 클래스를 만들어 제거할 수 있다.
- 공통으로 사용되는 로직은 상위 클래스에 두고 달라지는 부분만 하위 클래스에 둠으로써, 달라지는 부분만 강조할 수 있다.
- 모든 조건문을 다형성으로 바꿔야하는 것은 아니다.

# 섹션4. 긴 매개변수 목록
## 냄새4. 긴 매개변수 목록
Long Paramter List
- 어떤 함수에 매개변수가 많을수록 함수의 역할을 이해하기 어려워진다.
  - 과연 그 함수는 한가지 일을 하고 있는게 맞는가?
  - 불필요한 매개변수는 없는가?
  - 하나의 레코드로 뭉칠 수 있는 매개변수 목록은 없는가?
- 어떤 매개변수를 다른 매개변수를 통해 알아낼 수 있다면, "매개변수를 질의 함수로 바꾸기 (Replace Parameter with Query)"를 사용할 수 있다.
- 기존 자료구조에서 세부적인 데이터를 가져와서 여러 매개변수로 넘기는 대신, "객체 통째로 넘기기(Preserve Whole Object)"를 사용할 수 있다.
- 일부 매개변수들이 대부분 같이 넘겨진다면,"매개변수 객체 만들기 (Introduce Paramter Object)"를 적용할 수 있다.
- 매개변수가 플래그로 사용된다면, "플래그 인수 제거하기 (Remove Flag Argument)"를 사용할 수 있다.
- 여러 함수가 일부 매개변수를 공통적으로 사용한다면 "여러 함수를 클래스로 묶기 (Combine Functions into Class)"를 통해 매개변수를 해당 클래스의 필드로 만들고 메서드에 전달해야 할 매개변수 목록을 줄일 수 있다.

## 리팩토링14. 매개변수를 질의 함수로 바꾸기
Replace Parameter with Query
- 함수의 매개변수 목록은 함수의 다양성을 대변하며, 짧을수록 이해하기 좋다.
- 어떤 한 매개변수를 다른 매개변수를 통해 알아낼 수 있다면 "중복 매개변수"라 생각할 수 있다.
- 매개변수에 값을 전달하는 것은 "함수를 호출하는 쪽"의 책임이다. 가능하면 함수를 호출하는 쪽의 책임을 줄이고 함수 내부에서 책임지도록 노력한다.
- "임시 변수를 질의 함수로 바꾸기"와 "함수 선언 변경하기"를 통해 이 리팩토링을 적용한다.

## 리팩토링15. 플래그 인수 제거하기
Remove Flag Argument
- 플래그는 보통 함수에 매개변수로 전달해서, 함수 내부의 로직을 분기하는데 사용한다.
- 플래그를 사용한 함수는 차이를 파악하기 어렵다.
  - bookConcert(customer, false), bookConcert(customer, true)
  - bookConcert(customer), premiumBookConcert(customer)
- 조건문 분해하기 (Decompose Condition)를 활용할 수 있다.

## 리팩토링16. 여러 함수를 클래스로 묶기
Combine Functions into Class
- 비슷한 매개변수 목록을 여러 함수에서 사용하고 있다면 해당 메소드를 모아서 클래스를 만들 수 있다.
- 클래스 내부로 메소드를 옮기고, 데이터를 필드로 만들면 메소드에 전달해야 하는 매개변수 목록도 줄일 수 있다.

# 섹션5. 전역 데이터
## 냄새5. 전역 데이터
Global Data
- 전역 데이터 (예, 자바의 public static 변수)
- 전역 데이터는 아무곳에서나 변경될 수 있다는 문제가 있다.
- 어떤 코드로 인해 값이 바뀐 것인지 파악하기 어렵다.
- 클래스 변수(필드)도 비슷한 문제를 겪을 수 있다.
- "변수 캡슐화하기 (Encapsulate Variable)"를 적용해서 접근을 제어하거나 어디서 사용하는지 파악하기 쉽게 만들 수 있다.
- 파라켈수스의 격언, "약과 독의 차이를 결정하는 것은 사용량 뿐이다."

## 리팩토링17. 변수 캡슐화하기
Encapsulate Variable
- 메소드는 점진적으로 새로운 메소드로 변경할 수 있으나, 데이터는 한번에 모두 변경해야 한다.
- 데이터 구조를 변경하는 작업을 그보다는 조금 더 수월한 메소드 구조 변경 작업으로 대체할 수 있다.
- 데이터가 사용되는 범위가 클수록 캡슐화를 하는 것이 더 중요해졌다.
  - 함수를 사용해서 값을 변경하면 보다 쉽게 검증 로직을 추가하거나 변경에 따르는 후속 작업을 추가하는 것이 편리하다.
- 불변 데이터의 경우에는 이런 리팩토링을 적용할 필요가 없다.

# 섹션6. 가변 데이터
## 냄새6. 가변 데이터
Mutable Data
- 데이터를 변경하다보면 예상치 못했던 결과나 해결하기 어려운버그가 발생하기도 한다.
- 함수형 프로그래밍 언어는 데이터를 변경하지 않고 복사본을 전달한다. 하지만 그 밖의 프로그래밍 언어는 데이터 변경을 허용하고 있다. 따라서 변경되는 데이터 사용 시 발생할 수 있는 리스크를 관리할 수 있는 방법을 적용하는 것이 좋다.
- 관련 리팩토링
  - "변수 캡슐화하기 (Encapsulate Variable)"를 적용해 데이터를 변경할 수 있는 메소드를 제한하고 관리할 수 있다.
  - "변수 쪼개기 (Split Variable)"을 사용해 여러 데이터를 저장하는 변수를 나눌 수 있다.
  - "코드 정리하기 (Slide Statements)"를 사용해 데이터를 변경하는 코드를 분리하고 피할 수 있다.
  - "함수 추출하기 (Extract Function)"으로 데이터를 변경하는 코드로부터 사이드 이팩트가 없는 코드를 분리할 수 있다.
  - "질의 함수와 변경 함수 분리하기 (Separate Query from Modifier)"를 적용해서 클라이언트가 원하는 경우에만 사이드 이팩트가 있는 함수를 호출하도록 API를 개선할 수 있다.
  - 가능하다면 "세터 제거하기 (Remove Setting Method)"를 적용한다.
  - 계산해서 알아낼 수 있는 값에는 "파생 변수를 질의 함수로 바꾸기 (Replace Derived Variable with Query)"를 적용할 수 있다.
  - 변수가 사용되는 범위를 제한하려면 "여러 함수를 클래스로 묶기 (Combine Functions into Class)"또는 "여러 함수를 변환 함수로 묶기(Combine Functions into Transform)"을 적용할 수 있다.
  - "참조를 값으로 바꾸기 (Change Reference to Value)"를 적용해서 데이터 일부를 변경하기 보다는 데이터 전체를 교체할 수 있다.

## 리팩토링18. 변수 쪼개기
Split Variable
- 어떤 변수가 여러번 재할당 되어도 괜찮은 경우
  - 반복문에서 순회하는데 사용하는 변수 또는 인덱스
  - 값을 축적시키는데 사용하는 변수
- 그밖의 경우에 재할당되는 변수가 있다면 해당 변수는 여러 용도로 사용되는 것이며 변수를 분리해야 더 이해하기 좋은 코드를 만들 수 있다.
  - 변수 하나 당 하나의 책임(Responsibility)을 지도록 만든다.
  - 상수를 활용하자.(자바스크립트의 const, 자바의 final)

## 리팩토링19. 질의 함수와 변경 함수 분리하기
Separate Query from Modifier
- "눈에 띌만한" 사이드 이펙트 없이 값을 조회할 수 있는 메소드는 테스트 하기도 쉽고, 메소드를 이동하기도 편하다.
- 명령-조회 분리 (command-query separation) 규칙:
  - 어떤 값을 리턴하는 함수는 사이드 이펙트가 없어야 한다.
- "눈에 띌만한 (observable) 사이드 이펙트"
  - 가령, 캐시는 중요한 객체 상태 변화는 아니다. 따라서 어떤 메소드 호출로 인해, 캐시 데이터를 변경하더라도 분리할 필요는 없다.

## 리팩토링20. 세터 제거하기
Remove Setting Method
- 세터를 제공한다는 것은 해당 필드가 변경될 수 있다는 것을 뜻한다.
- 객체 생성시 처음 설정된 값이 변경될 필요가 없다면 해당 값을 설정할 수 있는 생성자를 만들고 세터를 제거해서 변경될 수 있는 가능성을 제거해야 한다.

## 리팩토링21. 파생 변수를 질의 함수로 바꾸기
Replace Derived Variable with Query
- 변경할 수 있는 데이터를 최대한 줄이도록 노력해야 한다.
- 계산해서 알아낼 수 있는 변수는 제거할 수 있다.
  - 계산 자체가 데이터의 의미를 잘 표현하는 경우도 있다.
  - 해당 변수가 어디선가 잘못된 값으로 수정될 수 있는 가능성을 제거할 수 있다.
- 계산에 필요한 데이터가 변하지 않는 값이라면, 계산의 결과에 해당하는 데이터 역시 불변 데이터기 때문에 해당 변수는 그대로 유지할 수 있다.

## 리팩토링22. 여러 함수를 변환 함수로 묶기
Combine Functions into Transform
- 관련있는 여러 파생 변수를 만들어내는 함수가 여러 곳에서 만들어지고 사용된다면 그러한 파생 변수를 "변환 함수(transform function)"를 통해 한 곳으로 모아둘 수 있다.
- 소스 데이터가 변경될 수 있는 경우에는 "여러 함수를 클래스로 묶기(Combine Functions into Class)"를 사용하는 것이 적절하다.
- 소스 데이터가 변경되지 않는 경우에는 두 가지 방법을 모두 사용할 수 있지만, 변환 함수를 사용해서 불변 데이터의 필드로 생성해 두고 재사용할 수도 있다.

## 리팩토링23. 참조를 값으로 바꾸기
Change Reference to Value
- 레퍼런스 (Reference) 객체 vs 값 (Value) 객체
  - https://martinfowler.com/bliki/ValueObject.html
  - "Objects that are equal due to the value of their properties, in this case thier x and y coordinates, are called value objects."
  - 값 객체는 객체가 가진 필드의 값으로 동일성을 확인한다.
  - 값 객체는 변하지 않는다.
  - 어떤 객체의 변경 내역을 다른 곳으로 전파시키고 싶다면 레퍼런스, 아니면 값 객체를 사용한다.

# 섹션7. 뒤엉킨 변경
## 냄새7. 뒤엉킨 변경
Divergent Change
- 소프트웨어는 변경에 유연하게(soft) 대처할 수 있어야 한다.
- 어떤 한 모듈이 (함수 또는 클래스가) 여러가지 이유로 다양하게 변경되어야 하는 상황.
  - 예) 새로운 결제 방식을 도입하거나, DB를 변경할 때 동일한 클래스에 여러 메소드를 수정해야 하는 경우
- 서로 다른 문제는 서로 다른 모듈에서 해결해야 한다.
  - 모듈의 책임이 분리되어 있을수록 해당 문맥을 더 잘 이해할 수 있으며 다른 문제는 신경쓰지 않아도 된다.
- 관련 리팩토링 기술
  - "단계 쪼개기(Split Phase)"를 사용해 서로 다른 문맥의 코드를 분리할 수 있다.
  - "함수 옮기기(Move Function)"를 사용해 적절한 모듈로 함수를 옮길 수 있다. 
  - 여러가지 일이 하나의 함수에 모여있다면 "함수 추출하기(Extract Function)"를 사용할 수 있다.
  - 모듈이 클래스 단위라면 "클래스 추출하기 (Extract Class)"를 사용해 별도의 클래스로 분리할 수 있다.

## 리팩토링24. 단계 쪼개기
Split Phase
- 서로 다른 일을 하는 코드를 각기 다른 모듈로 분리한다.
  - 그래야 어떤 것을 변경해야 할 때, 그것과 관련있는 것만 신경쓸 수 있다.
- 여러 일을 하는 함수의 처리 과정을 각기 다른 단계로 구분할 수 있다.
  - 예) 전처리 -> 주요 작업 -> 후처리
  - 예) 컴파일러: 텍스트 읽어오기 -> 실행 가능한 형태로 변경
- 서로 다른 데이터를 사용한다면 단계를 나누는데 있어 중요한 단서가 될 수 있다.
- 중간 데이터(intermediate Data)를 만들어 단계를 구분하고 매개변수를 줄이는데 활용할 수 있다.

## 리팩토링25. 함수 옮기기
Move Function
- 모듈화가 잘 된 소프트웨어는 최소한의 지식만으로 프로그램을 변경할 수 있다.
- 관련있는 함수나 필드가 모여있어야 더 쉽게 찾고 이해할 수 있다.
- 하지만 관련있는 함수나 필드가 항상 고정적인 것은 아니기 때문에 때에 따라 옮겨야 할 필요가 있다.
- 함수를 옮겨야 하는 경우
  - 해당 함수가 다른 문맥(클래스)에 있는 데이터(필드)를 더 많이 참조하는 경우
  - 해당 함수를 다른 클라이언트(클래스)에서도 필요로 하는 경우
- 함수를 옮겨갈 새로운 문맥(클래스)이 필요한 경우에는 "여러 함수를 클래스로 묶기(Combine Functions into Class)" 또는 "클래스 추출하기(Extract Class)"를 사용한다.
- 함수를 옮길 적당한 위치를 찾기가 어렵다면, 그대로 두어도 괜찮다. 언제든 나중에 옮길 수 있다.

응집도 : 관련있는 함수나 필드들이 한 곳에 모여있는 정도

## 리팩토링26. 클래스 추출하기
Extract Class
- 클래스가 다루는 책임(Responsibility)이 많아질수록 클래스가 점차 커진다.
- 클래스를 쪼개는 기준
  - 데이터나 메소드 중 일부가 매우 밀접한 관련이 있는 경우
  - 일부 데이터가 대부분 같이 바뀌는 경우
  - 데이터 또는 메소드 중 일부를 삭제한다면 어떻게 될 것인가?
- 하위 클래스를 만들어 책임을 분산시킬 수도 있다.

# 섹션8. 산탄총 수술
## 냄새8. 산탄총 수술
Shotgun Surgery 
- 어떤 한 변경 사항이 생겼을 때 여러 모듈을 (여러 함수 또는 여러 클래스를) 수정해야 하는 상황.
  - "뒤엉킨 변경" 냄새와 유사하지만 반대의 상황이다.
  - 예) 새로운 결제 방식을 도입하려면 여러 클래스의 코드를 수정해야 한다.
- 변경 사항이 여러 곳에 흩어진다면 찾아서 고치기도 어렵고 중요한 변경 사항을 놓칠 수 있는 가능성도 생긴다.
- 관련 리팩토링 기술
  - "함수 옮기기 (Move Function)" 또는 "필드 옮기기 (Move Field)"를 사용해서 필요한 변경 내역을 하나의 클래스로 모을 수 있다.
  - 비슷한 데이터를 사용하는 여러 함수가 있다면 "여러 함수를 클래스로 묶기 (Combine Functions into Class)"를 사용할 수 있다.
  - "단계 쪼개기 (Split Phase)"를 사용해 공통으로 사용되는 함수의 결과물들을 하나로 묶을 수 있다.
  - "함수 인라인 (Inline Function)"과 "클래스 인라인 (Inline Class)"로 흩어진 로직을 하나로 모을 수 있다.

## 리팩토링27. 필드 옮기기
Move Field
- 좋은 데이터 구조를 가지고 있다면, 해당 데이터에 기반한 어떤 행위를 코드로(메소드나 함수) 옮기는 것도 간편하고 단순해진다.
- 처음에는 타당해 보였던 설계적인 의사 결정도 프로그램이 다루고 있는 도메인과 데이터 구조에 대해 더 많이 익혀나가면서, 틀린 의사 결정으로 바뀌는 경우도 있다.
- 필드를 옮기는 단서:
  - 어떤 데이터를 항상 어떤 레코드와 함께 전달하는 경우
  - 어떤 레코드를 변경할 때 다른 레코드에 있는 필드를 변경해야 하는 경우
  - 여러 레코드에 동일한 필드를 수정해야 하는 경우
  - (여기서 언급한 '레코드'는 클래스 또는 객체로 대체할 수도 있음)

## 리팩토링28. 함수 인라인
Inline Function
- "함수 추출하기 (Extract Function)"의 반대에 해당하는 리팩토링
  - 함수로 추출하여 함수 이름으로 의도를 표현하는 방법.
- 간혹, 함수 본문이 함수 이름 만큼 또는 그보다 더 잘 의도를 표현하는 경우도 있다.
- 함수 리팩토링이 잘못된 경우에 여러 함수를 인라인하여 커다란 함수를 만든 다음에 다시 함수 추출하기를 시도할 수 있다.
- 단순히 메소드 호출을 감싸는 우회형 (indirection) 메소드라면 인라인으로 없앨 수 있다.
- 상속 구조에서 오버라이딩 하고 있는 메소드는 인라인 할 수 없다. (해당 메소드는 일종의 규약이니까)

## 리팩토링29. 클래스 인라인
Inline Class
- "클래스 추출하기 (Extract Class)"의 반대에 해당하는 리팩토링
- 리팩토링을 하는 중에 클래스의 책임을 옮기다보면 클래스의 존재 이유가 빈약해지는 경우가 발생할 수 있다.
- 두개의 클래스를 여러 클래스로 나누는 리팩토링을 하는 경우에, 우선 "클래스 인라인"을 적용해서 두 클래스의 코드를 한 곳으로 모으고 그런 다음에 "클래스 추출하기"를 적용해서 새롭게 분리하는 리팩토링을 적용할 수 있다.

# 섹션9. 기능 편애
## 냄새9. 기능 편애
Feature Envy
- 어떤 모듈에 있는 함수가 다른 모듈에 있는 데이터나 함수를 더 많이 참조하는 경우에 발생한다.
  - 예) 다른 객체의 getter를 여러개 사용하는 메서드
- 관련 리팩토링 기술
  - "함수 옮기기 (Move Function)"를 사용해서 함수를 적절한 위치로 옮긴다.
  - 함수 일부분만 다른 곳의 데이터와 함수를 많이 참조한다면 "함수 추출하기 (Extract Function)"로 함수를 나눈 다음에 함수를 옮길 수 있다.
- 만약에 여러 모듈을 참조하고 있다면? 그 중에서 가장 많은 데이터를 참조하는 곳으로 옮기거나, 함수를 여러개로 쪼개서 각 모듈로 분산 시킬 수도 있다.
- 데이터와 해당 데이터를 참조하는 행동을 같은 곳에 두도록 하자.
- 예외적으로, 데이터와 행동을 분리한 디자인 패턴 (전략 패턴 또는 방문자 패턴)을 적용할 수도 있다.

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

