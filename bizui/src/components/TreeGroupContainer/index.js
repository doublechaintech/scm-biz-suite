
import React, { PureComponent } from 'react'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'
import styles from './index.less'
import TreeSearch from '../TreeSearch'
import TreeGroupSearch from '../TreeGroupSearch'

class TreeContainer extends PureComponent {



    render() {

        const {showLeftTree, callbackFunction, callbackParameters} = this.props
        if(!showLeftTree){
            return (<div> 
                {this.props.children}
                </div>)
        }
        
        return (
            <div>
                <Col span={4} style={{ height: "100%" }}>
                    <Card bordered style={{ marginRight: "10px" }}>
                        <TreeSearch className={styles.tableList} 
                            callbackFunction={callbackFunction}
                            callbackParameters={callbackParameters}
                            {...this.props}
                        />
                    </Card>
                </Col>
                <Col span={20}>
                    {this.props.children}
                </Col>
            </div>)

    }



}




export default TreeContainer
