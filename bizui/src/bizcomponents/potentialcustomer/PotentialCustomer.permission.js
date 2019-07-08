

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
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


const internalSummaryOf = (potentialCustomer,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomer.id}</Description> 
<Description term="Name">{potentialCustomer.name}</Description> 
<Description term="Mobile">{potentialCustomer.mobile}</Description> 
<Description term="Description">{potentialCustomer.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomer.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  potentialCustomer = this.props.potentialCustomer;
    const { id,displayName, potentialCustomerContactPersonCount, potentialCustomerContactCount, eventAttendanceCount } = potentialCustomer
    const cardsData = {cardsName:"Potential Customer",cardsFor: "potentialCustomer",cardsSource: potentialCustomer,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  potentialCustomer: state._potentialCustomer,
}))(Form.create()(PotentialCustomerPermission))

