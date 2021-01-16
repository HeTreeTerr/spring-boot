package com.itcast.springboot.dto;

import com.itcast.springboot.entity.User;

import java.util.Iterator;

public class Users implements Iterable<User>{

    private User[] users;

    public Users() {
    }

    @Override
    public Iterator<User> iterator() {
        return new UserIterator();
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    // 实现Iterator接口的私有内部类，外界无法直接访问
    private class UserIterator implements Iterator<User> {
        // 当前迭代元素的下标
        private int index = 0;

        // 判断是否还有下一个元素，如果迭代到最后一个元素就返回false
        public boolean hasNext() {
            return index != users.length;
        }

        @Override
        public User next() {
            return users[index++];
        }

        // 这里不支持，抛出不支持操作异常
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
