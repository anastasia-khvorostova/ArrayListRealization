package com.example.demo;

import java.util.*;

public class ArrayListRealization<T> extends AbstractList<T>
        implements List<T>, RandomAccess, Cloneable, java.io.Serializable {
    private int size = 0;
    private int capacity;
    private final int CAPACITY = 16;
    private Object[] array;

    public ArrayListRealization() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    public ArrayListRealization(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    //Масштабирование списка
    private void resize() {
        Object[] newArray = new Object[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    //Получение элемента списка по индексу

    @Override
    public T get(int index) {
        if ((index < size) && (index >= 0)) {
            return (T) array[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            return false;
        }
        for (Object o : c) {
            if (contains(o)) {
                ;
            } else {
                return false;
            }
        }
        return true;
    }

    //индекс вхождения объекта в массив
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    //Вставка в конец списка
    @Override
    public boolean add(Object item) {
        if (size == array.length - 1)
            resize(); // увеличение в 2 раза, если достигли границ
        array[size++] = item;
        return true;
    }

    //Вставка на позицию index
    @Override
    public void add(int index, Object element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            resize();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    //Вставка коллекции начиная с индекса index
    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null) {
            return false;
        }
        if (c.isEmpty() || (index < 0)) {
            return false;
        }
        if (index > size) {
            index = size;
        }
        for (Object item : c) {
            add(index++, item);
        }
        return true;
    }

    //Удаление элемента из списка по индексу
    @Override
    public T remove(int index) {
        Object o = null;
        if ((index < size) && (index >= 0)) {
            o = get(index);
            size--;
            if (size <= 0) {
                return null;
            }
            if (size != index) {
                System.arraycopy(array, index + 1, array, index, size - index);
            }
            array[size] = null;
        }
        return (T) o;
    }

    //Удаление элемента из списка
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (get(i) == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(get(i))) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}