# GiftyCurrency
Web app, that connect currency API with a .gif API and throw a random gif depending on currency exchange rate

### If rates are high
![](https://github.com/korolyo/GiftyCurrency/blob/main/Images/rich.gif)




## git clone git@github.com:korolyo/GiftyCurrency.git
## cd GiftyCurrency
## 


Описание:
---
```
Если курс по отношению к рублю за сегодня стал выше вчерашнего,  
отдаем рандомную отсюда https://giphy.com/search/rich  
если ниже - отсюда https://giphy.com/search/broke
 
Запросы приходят на HTTP endpoint, туда передается код валюты
```
localhost:8080/{code}
```
Для взаимодействия с внешними сервисами используется Feign  
  
Для сборки используется Gradle  

Сборка и запуск Docker контейнера с этим сервисом
```  
Endpoints:
---  
Получить гифку  
(пример ответа: https://api.giphy.com/v1/gifs/random?api_key=LQIz0s73ixRR5Tn9uGNSPWumkNF1vVMk&tag=rich):
```
GET /{Currency Code}
```  
Простой html доступен по localhost:8080/  
 
Запуск .jar:
---
```
java -jar core-1.jar
```
Docker:
---
Для создания образа Docker перейти в корневую директорию проекта,  
где лежит фаил Dockerfile:  
```  
docker build core_image:gg .  
```
Запуск:   
```
docker run -p 8080:8080 core_image:gg 
``` 
Запуск: 
``` 
docker run -p 8080:8080 --name core core:latest
```
