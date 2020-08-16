# auth-keycloack

1 скачать и разархивировать https://www.keycloak.org/downloads.html нужной версии

2 перейти в каталог bin и запустить командой: ./standalone.sh -Djboss.socket.binding.port-offset=100

Возможно понадобится создать пользователя командой add-user.sh

3 Создать realm (пример SpringBootKeycloak) (realm_name)

4 создать client (login-app(client_name)) и в настройках указать redirect url(redirect_url) текущего приложения

5 создать пользователя и роль. Назначить роль вновьсозданному пользователю. Установить пароль.

6 в приложение установить проперти:

keycloak.auth-server-url=http://localhost:8180/auth | redirect_url
keycloak.realm=SpringBootKeycloak | realm_name
keycloak.resource=login-app | client_name
keycloak.public-client=true
keycloak.principal-attribute=preferred_username

7 run ./mvnw clean spring-boot:run