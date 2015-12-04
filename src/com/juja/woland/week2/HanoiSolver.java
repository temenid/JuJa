package com.juja.woland.week2;

/**
 * Created by woland on 11/27/15.
 */
/*

Правила игры очень просты. Есть 1 пирамидка с дисками разного размера, и еще 2 пустые пирамидки. Надо переместить диски с одной пирамидки на другую. Перекладывать можно только по одному диску за ход. Складывать диски можно только меньший на больший. В простом варианте рассматривается случай с тремя дисками. Более общий случай - n дисков.

Рекурсивное решение
Пронумеруем пирамидки - A, где изначально все диски, B, C. Нам надо перенести все диски с A -> C, B - промежуточная пирамида. Также обозначим диски в соответствии с радиусом - 3 2 1. 1 - наименьший. Изначальная позиция A: 321, B, C. Рекурсия заключается в следующем - переносим все диски кроме последнего (в более общем случае n-1 дисков) на промежуточный B, переносим последний диск на C, переносим все диски кроме последнего на C. Теперь вместо переноса 3х дисков и 2х свободных пирамидок, нам нужно решить задачу переноса 2х дисков и 2х свободных ячеек (мы можем класть диски меньшего радиуса на диск большего).

exchange(21, A, B)
exchange(3, A, C)
exchange(21, B, C)

Функция exchange переносит диск, если он один или запускает рекурсивную процедуру, если дисков больше одного. Напомню, что атомарным действием есть перенос 1 диска. Поэтому для переноса дисков 21 запускаем аналогичный алгоритм.

exchange(1, A, C)
exchange(2, A, B)
exchange(1, C, B)

Посмотрим шаги:
1. 1: A -> C (A 32, B, C 1)
2. 2: A -> B (A 3, B 2, C 1)
3. 1: C -> B (A 3, B 21, C)
4. 3: A -> C (A, B 21, C 3)
Теперь нужно запустить функцию перестановок с пирамидки B на пирамиду C.
5. 1: B -> A (A 1, B 2, C 3)
6. 2: B -> C (A 1, B, C 32)
7. 3: A -> C (A, B, C 321)

 */
import java.util.Stack;

public class HanoiSolver {
    public static void exchange (Stack from, Stack help, Stack to, int count) {
        if (count > 0) {

            //all disc, except biggest, move to B (to help) [recursivity] - C open for biggest; like exchange(21, A, B)
            exchange(from, to, help, count - 1);

            //deep-deep in recursion; move biggest to C; like exchange(3, A, C)
            int biggest = (int) from.pop();
            to.push(biggest);

            //all disc, except biggest, move from B (from help) to C ('to') [recursivity]; like exchange(21, B, C)
            exchange(help, from, to, count - 1);
        }
    }

    public static void main(String[] args) {
        Stack from  = new Stack();
        Stack help = new Stack();
        Stack to = new Stack();

        int count = 3;

        for (int i = count; i > 0; i--) {
            from.push(i);
        }

        exchange(from, help, to, count);

        for (int i = count; i > 0; i--) {
            System.out.println("el: " + (int)to.pop());
        }
    }
}
