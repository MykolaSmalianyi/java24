# Лабораторна робота: Валідація полів об’єктів у Java

## **Автор**
**Смаляний Микола ІО-21**

## **Опис проекту**
Цей проєкт реалізує систему валідації полів об’єктів у Java за допомогою кастомних анотацій і механізму рефлексії.  
Програма перевіряє дотримання умов, накладених на значення полів класів, таких як:
- Поле не може бути `null`.
- Довжина рядка повинна бути в заданому діапазоні.
- Числове значення має відповідати мінімальним та максимальним обмеженням.  

Проєкт включає:  
1. Створення власних анотацій для валідації (`@NotNull`, `@StringLength`, `@MinValue`, `@MaxValue`).  
2. Реалізацію валідатора, який перевіряє поля об'єктів за допомогою рефлексії.  
3. Демонстрацію роботи на прикладах трьох різних класів.  
4. Порівняння часу роботи валідації з використанням рефлексії та без неї.  

## **Особливості**
- Використання рефлексії для автоматичної перевірки полів на основі анотацій.  
- Валідація типів анотацій: програма повідомляє про помилку конфігурації, якщо анотація застосована до неправильного типу поля.  
- Підтримка налаштування мінімальних та максимальних значень, довжини рядка та перевірки на `null`.  
- Логування часу виконання для аналізу продуктивності.  

## **Вимоги**
- **Java 17** або новіша версія.  
- Середовище розробки, наприклад **IntelliJ IDEA** або **VS Code**.  

## Анотації:

- **@NotNull** — перевіряє, що поле не має значення null.
- **@StringLength** — перевіряє довжину рядка.
- **@MinValue** та **@MaxValue** — встановлюють мінімальні та максимальні обмеження для чисел.

## Класи:

- **Validator** — клас для перевірки полів об’єктів з використанням рефлексії.
- **EmployeeValidator** — валідатор без використання рефлексії для класу Employee.
- **User**, **Product**, **Employee** — демонстраційні класи для тестування різних сценаріїв валідації.

## Головний клас:

- **Main** — демонструє роботу програми через приклади з валідними та невалідними даними для кожного класу.