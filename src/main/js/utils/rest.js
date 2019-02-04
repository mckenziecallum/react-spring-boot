import axios from 'axios';

export function get() {
    axios.get("/api/").then(data => {
        console.log(data.data);
    })
}