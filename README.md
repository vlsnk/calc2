Создать класс фактори для создания команд. То есть создать отельный класс который будет
иметь с аргументом имя команды и возвращать реализацию интерфейса Command для
данной команды. Реализовать следующие возможности:
1. Конфигурация списка команд через property файл factory класса. 
2. Добавить режим «отладки» для команд: в данном режиме фактори возвращает не саму
команду, а Proxy объект (см java.lang.reflect.Proxy) 
