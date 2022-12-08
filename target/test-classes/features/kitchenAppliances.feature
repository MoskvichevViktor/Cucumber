# language: ru
# encoding: utf-8

Функция: Техника для кухни

  Предыстория:
    Дано Открыта страница "Стартовая страница сайта DNS"
    Когда Выполнен переход на страницу Бытовая техника

  @case-first-part1
  Сценарий: Отображение ссылки Бытовая техника
    Тогда Проверка: Отображение ссылки Бытовая техника
      | Бытовая техника|

  @case-first-part2
  Сценарий: Отображение текста Техника для кухни
    И Выполнен переход на страницу Техника для кухни
    Тогда Проверка: Отображение текста Техника для кухни
      | Техника для кухни|

  @case-first-part3
  Сценарий: Отображение ссылки Собери свою кухню
    И Выполнен переход на страницу Техника для кухни
    Тогда Проверка: Отображение ссылки Собрать свою кухню
      | Собрать свою кухню |

  @case-first-part4
  Сценарий: Отображение категорий Техника для кухни
    И Выполнен переход на страницу Техника для кухни
    Тогда Проверка: количества категорий раздела Техника для кухни больше чем <x>
      | 5 |
