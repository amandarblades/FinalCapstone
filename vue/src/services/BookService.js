import axios from 'axios';

export default {
    getBookByIsbn(isbn) {
        return axios.get(`/addbook/${isbn}`);
    },
    getBookList() {
        return axios.get(`/books`)
    }
    
}