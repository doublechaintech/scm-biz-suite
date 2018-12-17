/**
 * Created by hao.cheng on 2017/4/16.
 */
import React from 'react';
import '../style/index.less';
class Page extends React.Component {
    render() {
        return (
            <div style={{height: '100%', align: 'center'}}>
                {this.props.children}
            </div>
        )

    }
}

export default Page;