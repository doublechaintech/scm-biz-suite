

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
import styles from './ProvinceCenterEmployee.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (provinceCenterEmployee,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{provinceCenterEmployee.id}</Description> 
<Description term="名称">{provinceCenterEmployee.name}</Description> 
<Description term="手机">{provinceCenterEmployee.mobile}</Description> 
<Description term="电子邮件">{provinceCenterEmployee.email}</Description> 
<Description term="成立">{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = provinceCenterEmployee => {
  const {ProvinceCenterEmployeeBase} = GlobalComponents
  return <PermissionSetting targetObject={provinceCenterEmployee}  targetObjectMeta={ProvinceCenterEmployeeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ProvinceCenterEmployeePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  provinceCenterEmployee = this.props.provinceCenterEmployee;
    const { id,displayName,  } = provinceCenterEmployee
    const cardsData = {cardsName:"省中心员工",cardsFor: "provinceCenterEmployee",cardsSource: provinceCenterEmployee,
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
  provinceCenterEmployee: state._provinceCenterEmployee,
}))(Form.create()(ProvinceCenterEmployeePermission))

