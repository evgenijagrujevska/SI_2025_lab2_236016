# SI_2025_lab2_236016

## Евгенија Грујевска 236016


### Control Flow Graph

![CFG](cfg/cfg1.svg)

### Цикломатска комплексност
Цикломатската комплексност е 9, добиена со формулата V(G)=P+1 каде што P=8 е број на предикатни јазли.
Или истото се добива и со формулата V(G)= E - N + 2 = број на рабови - број на јазли + 2 = 31 - 24 + 2 = 9

### Тест случаи според Every Statement критериумот

- За да се постигне овој критериум мора да има минимално 5 тест случаи:

TC1
- allItems=null , cardNumber=any
- За линиите од кодот 52,53  ( if (allItems == null) и Throw Exception )

TC2
- allItems=[("", 1, 100, 0)] , cardNumber=any
- За линиите од кодот 56-61  ( sum=0, for, Item item=allItems.get(i), if(item.getName() == null || item.getName().length() == 0) и Throw Exception )

TC3
- allItems=[("A", 11, 400, 0.4)] , cardNumber=null
- За линиите од кодот 64-70 ( if(item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10), sum -= 30, if(item.getDiscount() > 0) и sum со попуст) и за 87 (во последниот else Throw exception)


TC4
- allItems=[("B", 11, 100, 0)] , cardNumber="1234abcd56789123"
- За линиите од кодот 72 (sum без попуст во else делот) и 76-82 ( if(cardNumber != null && cardNumber.length() == 16) и линиите во тој if услов и за if(allowed.indexOf(c) == -1) со Throw Exception )

TC5
- allItems=[("C",11,100,0)] , cardNumber="1234567891234567"
- Со ова и return sum кога сите влезови се валидни



### Тест случаи според Multiple Condition критериумот
за условот if(item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

- За да се постигне овој критериум мора да има минимално 4 тест случаи:

TXX:	item.getPrice()>300 
- Првиот услов е точен а останатите не се евалуираат  => ("A",5,400,0)

FTX:	item.getPrice()<=300, item.getDiscount()>0
- Првиот услов е неточен, вториот е точен	 =>	("B",5,250,0.5)

FFT:	item.getPrice()<=300, item.getDiscount()<=0, item.getQuantity()>10
- Само третиот услов е точен => ("C",15,250,0)

FFF:	item.getPrice()<=300, item.getDiscount()<=0, item.getQuantity()<=10
- Сите услови се неточни - ова е случајот кога условот не се исполнува	=>  ("D",5,250,0)


Со овие 4 тест случаи, се постигнува покривање на сите можни излезни резултати од условот (true и false).



### Објаснување на unit тестовите

- За Every Statement има 4 тест случаи за кои се користи assertThrows за фрлање ислкучоци и 1 тест случај со assertEquals за проверка на sum.

- За Multiple Condition има 4 тест случаи за кои се користи assertEquals за проверка на сумите на секој од нив.
