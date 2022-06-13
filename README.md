# GiftyCurrency
Web app, that connect currency API with a .gif API and throw a random gif depending on currency exchange rate

### If rates are high
![](https://github.com/korolyo/GiftyCurrency/blob/main/Images/rich.gif)


Описание:
---
```
Если курс по отношению к рублю за сегодня стал выше вчерашнего,  
отдаем рандомную gif отсюда https://giphy.com/search/rich  
если ниже - отсюда https://giphy.com/search/broke
 
Запросы приходят на HTTP endpoint, туда передается код валюты

Для взаимодействия с внешними сервисами используется Feign  
  
Для сборки используется Gradle  

Сборка и запуск Docker контейнера с этим сервисом
```  

##Как запускать
```
 git clone git@github.com:korolyo/GiftyCurrency.git
 cd GiftyCurrency
```
1.1. Запуск .jar:
---
```
java -jar /build/libs/core-1.jar
```
##1.2. Docker
```
docker-compose up --build
```
ИЛИ
```
docker-compose up
```
2. Далее в браузере
```
localhost:8080/{code}
```
Вместо {code} - трехзначный код валюты
Например:
* JPY
* EUR
* RUB
* UAH
* AUD

Endpoints:
---  
Получить гиф  
(пример ответа: https://api.giphy.com/v1/gifs/random?api_key=LQIz0s73ixRR5Tn9uGNSPWumkNF1vVMk&tag=rich):
```
GET /{Currency Code}
```
