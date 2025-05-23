# SI_2025_lab2_236016

## Евгенија Грујевска 236016


### Control Flow Graph

![CFG](cfg/cfg1.svg)

### Цикломатска комплексност
Цикломатската комплексност е 9, добиена со формулата V(G)=P+1 каде што P=8 е број на предикатни јазли.
Или истото се добива и со формулата V(G)= E - N + 2 = број на рабови - број на јазли + 2 = 31 - 24 + 2 = 9

### Тест случаи според Every Statement критериумот

- За да се постигне овој критериум мора да има минимално 8 тест случаи:

TC1
- За if(allItems == null) и Throw Exception
- checkCart(null, "123456789")

TC2
- За if(item.getName() == null || item.getName().length() == 0) и Throw Exception
- checkCart(List.of(new Item("", 1, 100, 0)), "123456789")

TC3
- За if(item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10) и sum -= 30
- checkCart(List.of(new Item("A", 1, 400, 0)), "123456789"))

TC4
- За if(item.getDiscount() > 0) и sum со попуст
- checkCart(List.of(new Item("B", 2, 100, 0.1)), "123456789")

TC5
- За sum без попуст во else делот
- checkCart(List.of(new Item("C", 11, 100, 0.0)), "123456789")

TC6
- За if(cardNumber != null && cardNumber.length() == 16) и линиите во тој if услов
- checkCart(List.of(new Item("D", 1, 100, 0)), "1234567891234567")

TC7
- За if(allowed.indexOf(c) == -1) и Throw Exception
- checkCart(List.of(new Item("E", 1, 100, 0)), "1234abcd56789123")

TC8
- За последниот else и Throw Exception
- checkCart(List.of(new Item("F", 1, 100, 0)), "12345")


### Тест случаи според Multiple Condition критериумот
за условот if(item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

- За да се постигне овој критериум мора да има минимално 4 тест случаи:

TXX	item.getPrice()>300							(400,0,5)

FTX	item.getPrice()<=300, item.getDiscount()>0				(250,0.5,5)

FFT	item.getPrice()<=300, item.getDiscount()<=0, item.getQuantity()>10	(250,0,15)

FFF	item.getPrice()<=300, item.getDiscount()<=0, item.getQuantity()<=10	(250,0,5)


- Со овие 4 тест случаи, се постигнува покривање на сите можни излезни резултати од условот (true и false).

TXX: Првиот услов е точен, па останатите не се евалуираат (short-circuit)

FTX: Првиот услов е неточен, вториот е точен

FFT: Само третиот услов е точен

FFF: Сите услови се неточни - ова е единствениот случај кога условот не се исполнува


### Објаснување на unit тестовите
