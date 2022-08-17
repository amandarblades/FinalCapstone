import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    activity: {
      id: 0,
      title: '',
      description: '',
      minutesRead: 0,
      dateCompleted: '',
      notes: '',
      username: ''
    },

    token: currentToken || '',
    user: currentUser || {},

    book: {
      title: '',
      author: '',
      status: '',
      isbn: '',
      imgURL: '@/public/darkGreyThumbnailBW.png'
    },
    books: [
      {
        title: '',
        author: '',
        status: '',
        isbn: '',
        imgURL: '@/public/darkGreyThumbnailBW.png'
      }
    ],
    activities: [
      {
        id: 0,
        title: '',
        description: '',
        minutesRead: 0,
        dateCompleted: '',
        notes: '',
        username: ''
      },
    ],
    familyUser: {
      username: '',
      minutesRead: 0
    },
    familyUsers: [
      {
        username: '',
        minutesRead: 0
      }
    ],
    familyName: '',
    prize: {
      prizeID: 0,
      prizeName: '',
      startDate: '',
      endDate: '',
      maxPrize: 0,
      milestone: 0,
      description: '',
      userRole: '',
      numOfPrizeWinners: 0,
      isActive: true

    },
    prizes: [
      {
        prizeID: 0,
        prizeName: '',
        startDate: '',
        endDate: '',
        maxPrize: 0,
        milestone: 0,
        description: '',
        userRole: '',
        numOfPrizeWinners: 0,
        isActive: true
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_CURRENT_BOOK(state, data) {
      state.book = data;
    },
    SET_CURRENT_USER_BOOKS(state, data) {
      state.books = data;
    },
    SET_FAMILY_NAME(state, data) {
      state.familyName = data;
    },
    SET_FAMILY_MEMBERS(state, data) {
      state.familyUsers = data;
    },
    // ADD_ACTIVITY(state, data){
    //      state.activity.push(data)
    // },
    SET_ACTIVITY(state, data) {
      state.activity = data;
    },
    SET_CURRENT_ACTIVITIES(state, data) {
      state.activities = data;
    },
    SET_PRIZE(state, data) {
      state.prize = data;
    },
    SET_CURRENT_PRIZES(state, data){
         state.prizes=data;
    }
  }
})
