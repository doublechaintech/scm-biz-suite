

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
import styles from './PotentialCustomerContact.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (potentialCustomerContact,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomerContact.id}</Description> 
<Description term="Name">{potentialCustomerContact.name}</Description> 
<Description term="Contact Date">{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</Description> 
<Description term="Contact Method">{potentialCustomerContact.contactMethod}</Description> 
<Description term="Description">{potentialCustomerContact.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = potentialCustomerContact => {
  const {PotentialCustomerContactBase} = GlobalComponents
  return <PermissionSetting targetObject={potentialCustomerContact}  targetObjectMeta={PotentialCustomerContactBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PotentialCustomerContactPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  potentialCustomerContact = this.props.potentialCustomerContact;
    const { id,displayName,  } = potentialCustomerContact
    const cardsData = {cardsName:"Potential Customer Contact",cardsFor: "potentialCustomerContact",cardsSource: potentialCustomerContact,
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
  potentialCustomerContact: state._potentialCustomerContact,
}))(Form.create()(PotentialCustomerContactPermission))

