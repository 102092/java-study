## 참고

- [JavaTPC 실전프로젝트]([https://www.inflearn.com/course/%EC%9E%90%EB%B0%94API%ED%99%9C%EC%9A%A9-%EC%8B%A4%EC%A0%84%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/dashboard](https://www.inflearn.com/course/자바API활용-실전프로젝트/dashboard))
- 운영체제 : Mac 
- IDE : Visual Studio Code



## 목표

- 배웠던 것을 다시 복습



## JSON





## Socket

- TCP 3 - way Handshake
  - 3번의 절차를 거쳐서 소켓이 만들어진다.
- PC -- PC 통신을 하기 위해서는 **Socket**을 통해서 통신을 해야만 함
  - PC (end point == socket). ----- Lan ----- (end point == socke) PC
- Lan
  - IP, Port를 가지고 있음.
    - Java에서는 이 부분을 객체, 클래스로 다루고 있음.
    - 어떤 클래스? Socket 클래스
    - <u>즉 Socket 클래스는 IP 주소와 Port 번호를 가지고 있다.</u>

- 클라이언트  clinet
- 서버 server

- Socket은 두가지 종류

  - socket, Server Socket

  - 서버 소켓은, 서버쪽에만 생성되는 소켓. 클라이언트의 접속을 받아주기 위한 소켓

  - 서버 소켓은 받아주기 위한 소켓이지, 통신을 하기 위한 소켓은 아니다.

    - 통신을 하기위한 다른 포트로 연결하는 역할 (<u>안내원</u>) || **binding을** 해줌.

    - binidng을 통해 만들어지는 socket, 클라이언트 정보를 알고 있음.

- 클라이언트가 서버에 접속을 시도할때, 클라이언트 자신의 정보(IP, Port)를 서버쪽에 제공해줘야, 접속할 수있음.(서버쪽 정보는 당연히 알아야하고)



- Socket 에는 $accpet$가 있음.
  - 목적?
    1. 접속 대기
    2. 클라이언트 식별
    3. 수락
    4. 바인딩(**소켓생성**)
    5. 생성된 소켓정보를 전송

- 서버입장에서, 여러개의 클라이언트가 접속을 요청하면 어떻게 이 정보를 관리할까?
  - Server에는 배열적인 구조(List, HashMap)를 가지고 있다가, 소켓이 만들어지면 이 정보를 이 배열에 담아서 저장해놓음.

- 한글은 byte stream
  - 깨지지 않기 위해서 `readUTF()` 메서드를 사용한다.

