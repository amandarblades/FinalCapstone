import axios from 'axios';

export default {
    getBookByTitle(title) {
        return axios.get(`/addbook/${title}`);
    },
    getBookList() {
        return axios.get(`/books`)
    },
    getBookDetails(title){
         return axios.get(`/book/${title}`);
    }
}