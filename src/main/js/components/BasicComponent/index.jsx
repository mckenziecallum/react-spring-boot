import React, {Component} from 'react';

import style from './BasicComponent.css';

export default class BasicComponent extends Component {
    render() {
        return (
            <div className={style.test}>
                Some text here
            </div>
        );
    }
}