# java-calculator-precourse

## 구현할 기능 목록

### 1. 문자열을 입력받는 기능

- 문자열을 입력받는다.
- 입력값이 없을 시 `IllegalArgumentException`을 반환한다.

### 2. 구분자를 확인하는 기능

- 커스텀 구분자가 있는지 확인하고, 있으면 기본 구분자에 포함해서 구분한다. 없으면 기본 구분자로만 진행한다.
- 커스텀 구분자가 숫자이거나, 여러개일 수 있다.
- 구분자 형식에서 예외가 생길시 `IllegalArgumentException`을 반환한다.

### 3. 문자열에서 숫자를 추출하는 기능

- 문자열에서 구분자를 기준으로 숫자를 추출한다.
- 추출된 숫자가 숫자가 아니라면 `IllegalArgumentException`을 반환한다.
- 숫자가 양수가 아니라면 `IllegalArgumentException`을 반환한다.

### 4. 추출한 숫자를 더하는 기능

### 5. 더한 숫자를 표시하는 기능

### 이후 - 연결 및 리팩토링

## 예외 분류

현재 프로젝트에서 구현된 예외들은 모두 `IllegalArgumentException`을 사용하며, 다음과 같이 분류됩니다:

### 1. 입력 검증 예외 (Input Validation)

#### CalcInput 클래스
- **null 입력 검증**: `"input cannot be null"`
  - 사용자가 null 값을 입력했을 때 발생

### 2. 숫자 파싱 예외 (Number Parsing)

#### NumberExtractor 클래스  
- **숫자 형식 오류**: `"non-numeric value: {token}"`
  - 문자열을 BigDecimal로 변환할 수 없을 때 발생
  - 예: "abc", "1.2.3" 등

### 3. 도메인 규칙 예외 (Domain Rules)

#### Numbers 클래스
- **null 리스트 검증**: `"values must not be null"`
  - Numbers 생성자에 null 리스트가 전달될 때 발생
- **null 숫자 검증**: `"number must not be null"`  
  - 리스트 내부에 null 값이 있을 때 발생
- **양수 검증**: `"non-positive number: {value}"`
  - 0 이하의 숫자가 포함될 때 발생
  - 예: -1, 0 등

### 4. 연산 예외 (Operation)

#### AddOperation 클래스
- **null 리스트 검증**: `"numbers must not be null"`
  - calculate 메서드에 null 리스트가 전달될 때 발생
- **null 숫자 검증**: `"number must not be null"`
  - 리스트 내부에 null 값이 있을 때 발생

### 5. 출력 예외 (Output)

#### CalcOutput 클래스
- **null 결과 검증**: `"result must not be null"`
  - formatResult 메서드에 null 값이 전달될 때 발생


