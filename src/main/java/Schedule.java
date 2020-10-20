import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface Schedule {
    List<Days> weekday =  new List<Days>() {
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
        public Iterator<Days> iterator() {
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
        public boolean add(Days days) {
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
        public boolean addAll(Collection<? extends Days> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Days> collection) {
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
        public Days get(int i) {
            return null;
        }

        @Override
        public Days set(int i, Days days) {
            return null;
        }

        @Override
        public void add(int i, Days days) {

        }

        @Override
        public Days remove(int i) {
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
        public ListIterator<Days> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Days> listIterator(int i) {
            return null;
        }

        @Override
        public List<Days> subList(int i, int i1) {
            return null;
        }
    };
}
