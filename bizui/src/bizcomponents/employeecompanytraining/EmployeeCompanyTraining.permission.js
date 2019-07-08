

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
import styles from './EmployeeCompanyTraining.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (employeeCompanyTraining,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeCompanyTraining.id}</Description> 
<Description term="Current Status">{employeeCompanyTraining.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = employeeCompanyTraining => {
  const {EmployeeCompanyTrainingBase} = GlobalComponents
  return <PermissionSetting targetObject={employeeCompanyTraining}  targetObjectMeta={EmployeeCompanyTrainingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class EmployeeCompanyTrainingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  employeeCompanyTraining = this.props.employeeCompanyTraining;
    const { id,displayName,  } = employeeCompanyTraining
    const cardsData = {cardsName:"Employee Company Training",cardsFor: "employeeCompanyTraining",cardsSource: employeeCompanyTraining,
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
  employeeCompanyTraining: state._employeeCompanyTraining,
}))(Form.create()(EmployeeCompanyTrainingPermission))

