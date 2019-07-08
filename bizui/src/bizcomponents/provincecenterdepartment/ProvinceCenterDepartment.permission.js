

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
import styles from './ProvinceCenterDepartment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (provinceCenterDepartment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{provinceCenterDepartment.id}</Description> 
<Description term="Name">{provinceCenterDepartment.name}</Description> 
<Description term="Founded">{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Manager">{provinceCenterDepartment.manager}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = provinceCenterDepartment => {
  const {ProvinceCenterDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={provinceCenterDepartment}  targetObjectMeta={ProvinceCenterDepartmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ProvinceCenterDepartmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  provinceCenterDepartment = this.props.provinceCenterDepartment;
    const { id,displayName, provinceCenterEmployeeCount } = provinceCenterDepartment
    const cardsData = {cardsName:"Province Center Department",cardsFor: "provinceCenterDepartment",cardsSource: provinceCenterDepartment,
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
  provinceCenterDepartment: state._provinceCenterDepartment,
}))(Form.create()(ProvinceCenterDepartmentPermission))

