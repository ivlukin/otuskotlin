**API**

**Сущности**
1. Profile
2. Match
4. UserAttribute

**Описание сущности Profile**
1. Info - базовая информация профиля (обязательные поля)
    1.1. Gender - гендер (Male/Female) (UserAttribute)
    1.2. Age - возраст (число, 18-99) (UserAttribute)
    1.3. City - город, (1-32 символа) (UserAttribute)
    1.4. Profession - профессия (1-32 символа) (UserAttribute)
    1.5. Description - описание (1-512 символов) (UserAttribute)
    1.6. Telegram - контакт в Telegram
2. Id - идентификатор (long)
3. List of UserAttribute - список продвинутых критериев (Образование, Знак Зодиака, Цель знакомства)
4. List of Matches - список пар пользователя
5. List of Likes - список id пользователей, которым данный пользователь поставил лайк
6. List of noLike - список id пользователей, которых данный пользователь видел и НЕ поставил лайк

**Функции Profile**
1. CRUD
2. next - следующий пользователь из карусели
3. like - поставить лайк пользователю и показать следующему
4. listMatches - показать список пар
5. removeMatch - удалить пару

**Описание сущности Match**
1. FirstUser - первый пользователь пары (id)
2. SecondUser - второй пользователь пары (id)
3. createDateTime - время создания пары (DateTime)

Описание сущности UserAttribute
1. Name - имя аттрибута (1-128 символов)
2. Value - значение (1-128 символов)


