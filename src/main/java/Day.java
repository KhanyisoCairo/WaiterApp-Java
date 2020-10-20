import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface Day {
    String day = "";
    List<Person> waiters = new List<Person>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Person> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(Person person) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Person> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Person> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Person get(int i) {
            return null;
        }

        @Override
        public Person set(int i, Person person) {
            return null;
        }

        @Override
        public void add(int i, Person person) {

        }

        @Override
        public Person remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Person> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Person> listIterator(int i) {
            return null;
        }

        @Override
        public List<Person> subList(int i, int i1) {
            return null;
        }
    };
}
