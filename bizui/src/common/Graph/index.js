
import React from 'react'
import { Collapse} from 'antd'

import Graph from './graph'


const {Panel}=Collapse
export default class GraphWrapper extends React.Component {
  

  render() {
    
    
   

    return (
      <Collapse bordered={false}>
        <Panel header={'打开关系图'}><Graph /></Panel>
        
        
      </Collapse>
      
    )
  }
}