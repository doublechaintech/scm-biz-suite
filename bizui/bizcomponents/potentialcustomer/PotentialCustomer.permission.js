

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PotentialCustomer.profile.less'
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
const internalSummaryOf = (potentialCustomer,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{potentialCustomer.id}</Description> 
<Description term="名称">{potentialCustomer.name}</Description> 
<Description term="手机">{potentialCustomer.mobile}</Description> 
<Description term="描述">{potentialCustomer.description}</Description> 
<Description term="更新于">{ moment(potentialCustomer.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = potentialCustomer => {
  const {PotentialCustomerBase} = GlobalComponents
  return <PermissionSetting targetObject={potentialCustomer}  targetObjectMeta={PotentialCustomerBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PotentialCustomerPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  potentialCustomer = this.props.potentialCustomer
    const { id,displayName, potentialCustomerContactPersonCount, potentialCustomerContactCount, eventAttendanceCount } = potentialCustomer
    const  returnURL = `/potentialCustomer/${id}/workbench`
    const cardsData = {cardsName:"潜在的客户",cardsFor: "potentialCustomer",cardsSource: potentialCustomer,displayName,returnURL,
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
  potentialCustomer: state._potentialCustomer,
}))(Form.create()(PotentialCustomerPermission))

