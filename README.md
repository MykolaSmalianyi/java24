# # Лабораторна робота: Валідація Об'єктів та Генерація SQL Запитів

Цей проект демонструє, як використовувати кастомні анотації для валідації об'єктів та генерації SQL запитів на основі структури класів. Анотації валідації дозволяють накладати обмеження на поля об'єктів, а утиліти для генерації SQL допомагають створювати запити для створення таблиць і вставки даних.

## **Автор**
**Смаляний Микола ІО-21**

## Особливості

- **Кастомні анотації валідації**:
  - `@NotNull` для перевірки на `null`.
  - `@StringLength` для обмежень на довжину рядка.
  - `@MinValue` і `@MaxValue` для перевірки числових значень.

- **Генерація SQL**:
  - Генерація SQL запитів `CREATE TABLE` на основі полів класу.
  - Генерація SQL запитів `INSERT INTO` для вставки даних об'єкта у таблицю.

- **Валідація через рефлексію**:
  - Клас `ObjectValidator` використовує рефлексію для перевірки полів об'єкта відповідно до обмежень, заданих анотаціями.

## Структура

### Анотації
- **MaxValue**: Забезпечує, щоб значення поля не перевищувало задане максимальне значення.
- **MinValue**: Забезпечує, щоб значення поля не було менше заданого мінімального значення.
- **NotNull**: Забезпечує, щоб поле не було `null`.
- **StringLength**: Забезпечує, щоб довжина рядка відповідала заданому діапазону.

### Класи
- **SQLGenerator**: Містить методи для генерації SQL запитів на основі структури класів.
  - `generateCreateTableSQL(Class<?> clazz)` - Генерує SQL запит `CREATE TABLE`.
  - `generateInsertSQL(Object obj)` - Генерує SQL запит `INSERT INTO` для вставки даних об'єкта.

- **ObjectValidator**: Валідатор для перевірки об'єктів на основі анотацій з використанням рефлексії.

### Приклад Моделей
- **User**: Модель користувача з полями, такими як `name`, `email` та `age`.
- **Product**: Модель продукту з полями, такими як `name` та `price`.
- **Animal**: Модель тварини з полями, такими як `species` та `nickname`.
- **Customer**: Модель клієнта з полями, такими як `name`, `email` та `loyaltyPoints`.
- **Order**: Модель замовлення з полями, такими як `orderId`, `quantity` та `totalPrice`.

### Головний Клас
- **Main**: Демонструє, як використовувати валідацію та генерацію SQL для різних моделей, таких як `User` та `Product`.

## Використання

1. **Додайте анотації валідації до ваших моделей**: Позначте поля в ваших класах анотаціями, такими як `@NotNull`, `@MinValue`, `@MaxValue` та `@StringLength`.
   
2. **Валідуйте об'єкти**: Використовуйте метод `ObjectValidator.validate(Object obj)` для валідації екземпляра об'єкта на відповідність вказаним анотаціям.

3. **Генеруйте SQL запити**:
   - Використовуйте метод `SQLGenerator.generateCreateTableSQL(Class<?> clazz)` для генерації SQL запиту `CREATE TABLE`.
   - Використовуйте метод `SQLGenerator.generateInsertSQL(Object obj)` для генерації SQL запиту `INSERT INTO` для об'єкта.

## Приклад

```java
void validateAndGenerateSQL(Object obj) {
  try {
    ObjectValidator.validate(obj);
    String tableSQL = SQLGenerator.generateCreateTableSQL(obj.getClass());
    String insertSQL = SQLGenerator.generateInsertSQL(obj);
    System.out.println(tableSQL);
    System.out.println(insertSQL);
  } catch (Exception e) {
    System.err.println("Помилка валідації або генерації SQL для " + obj.getClass().getSimpleName() + ": " + e.getMessage());
  }
}

// Демонстрація для User
User user = new User("Alice", "alice@example.com", 30);
validateAndGenerateSQL(user);

// Демонстрація для неправильних даних
User invalidUser = new User(null, "invalid@example", 25);
validateAndGenerateSQL(invalidUser);
```

### Результат

```
CREATE TABLE User (
  name VARCHAR(255),
  email VARCHAR(255),
  age INT
);
INSERT INTO User (name, email, age) VALUES ('Alice', 'alice@example.com', 30);

Помилка валідації або генерації SQL для User: Поле name не може бути null
Невалідний формат email адреси
```