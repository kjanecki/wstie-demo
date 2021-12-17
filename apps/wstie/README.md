### Budowanie aplikacji
w konsoli IntelliJ IDEA:

```
mvn clean install
```

### Budowanie obrazu Dockera

w wierszu poleceń uruchomionym w folderze z projektem:

```
docker build -t kjanecki/wstie-demo:1.0.0 .
```

Uwaga na kropkę na końcu - oznacza że budujemy obraz w danym folderze

### Uruchamianie

```
docker run --name wstie-demo -p 8090:8080 kjanecki/wstie-demo:1.0.0
```

lub w tle z opcją ```-d```

```
docker run --name wstie-demo -p 8090:8080 kjanecki/wstie-demo:1.0.0 -d
```

UWAGA! jeśli wystąpią błędy z połączeniem do bazy PostgreSQL lub brokera RabbitMQ
należy zaktualizwoać plik src/main/resources/application.yml i zmienić adresy z localhost
na nazwę serwisu z docker-compose.yml, a następnie ponownie zbudować aplikację i zbudować obraz.

### Usuwanie

```
docker stop wstie-demo
docker rm wstie-demo
```