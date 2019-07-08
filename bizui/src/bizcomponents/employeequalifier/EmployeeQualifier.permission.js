

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
import styles from './EmployeeQualifier.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeQualifier,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeQualifier.id}</Description> 
<Description term="Qualified Time">{ moment(employeeQualifier.qualifiedTime).format('YYYY-MM-DD')}</Description> 
<Description term="Type">{employeeQualifier.type}</Description> 
<Description term="Level">{employeeQualifier.level}</Description> 
<Description term="Remark">{employeeQualifier.remark}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeQualifier => {
  const {EmployeeQualifierBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeQualifier}  targetObjectMeta={EmployeeQualifierBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeQualifierPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeQualifier = this.props.employeeQualifier;
    const { id,displayName,  } = employeeQualifier
    const cardsData = {cardsName:"Employee Qualifier",cardsFor: "employeeQualifier",cardsSource: employeeQualifier,
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
  employeeQualifier: state._employeeQualifier,
}))(Form.create()(EmployeeQualifierPermission))

