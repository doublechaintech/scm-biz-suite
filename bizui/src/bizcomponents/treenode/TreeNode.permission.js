

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TreeNode.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (treeNode,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{treeNode.id}</Description> 
<Description term="节点ID">{treeNode.nodeId}</Description> 
<Description term="节点类型">{treeNode.nodeType}</Description> 
<Description term="左值">{treeNode.leftValue}</Description> 
<Description term="右值">{treeNode.rightValue}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = treeNode => {
  const {TreeNodeBase} = GlobalComponents
  return <PermissionSetting targetObject={treeNode}  targetObjectMeta={TreeNodeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TreeNodePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  treeNode = this.props.treeNode
    const { id,displayName,  } = treeNode
    const  returnURL = `/treeNode/${id}/workbench`
    const cardsData = {cardsName:"节点",cardsFor: "treeNode",cardsSource: treeNode,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  treeNode: state._treeNode,
}))(Form.create()(TreeNodePermission))

