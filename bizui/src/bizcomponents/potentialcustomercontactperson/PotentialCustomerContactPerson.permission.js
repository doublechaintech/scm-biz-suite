

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
import styles from './PotentialCustomerContactPerson.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (potentialCustomerContactPerson,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomerContactPerson.id}</Description> 
<Description term="Name">{potentialCustomerContactPerson.name}</Description> 
<Description term="Mobile">{potentialCustomerContactPerson.mobile}</Description> 
<Description term="Description">{potentialCustomerContactPerson.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = potentialCustomerContactPerson => {
  const {PotentialCustomerContactPersonBase} = GlobalComponents
  return <PermissionSetting targetObject={potentialCustomerContactPerson}  targetObjectMeta={PotentialCustomerContactPersonBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PotentialCustomerContactPersonPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  potentialCustomerContactPerson = this.props.potentialCustomerContactPerson;
    const { id,displayName, potentialCustomerContactCount } = potentialCustomerContactPerson
    const cardsData = {cardsName:"Potential Customer Contact Person",cardsFor: "potentialCustomerContactPerson",cardsSource: potentialCustomerContactPerson,
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
  potentialCustomerContactPerson: state._potentialCustomerContactPerson,
}))(Form.create()(PotentialCustomerContactPersonPermission))

