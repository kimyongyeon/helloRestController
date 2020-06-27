package com.hello.hellorestcontroller.ioc;

public class CPU {

    class Computer {
        private CPU cpu;

        // 주입전
        public Computer() {
            cpu = new CPU();
        }

        // 주입방식
        public void setCpu(CPU cpu) {
            this.cpu = cpu;
        }
    }

    // 제어의 역전
    // 어떠한 일을 수행하도록 만들어진 프레임워크에 제어권을 위임함으로써 관심사를 분리하는 것을 의미한다. 
}
