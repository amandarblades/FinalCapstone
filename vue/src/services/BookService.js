import axios from 'axios';

export default {
    getBookByTitle(title) {
        return axios.get(`/${title}`);
    }
}