

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
import styles from './CompanyTraining.preference.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (companyTraining,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{companyTraining.id}</Description> 
<Description term="头衔">{companyTraining.title}</Description> 
<Description term="时间开始">{ moment(companyTraining.timeStart).format('YYYY-MM-DD')}</Description> 
<Description term="持续时间">{companyTraining.durationHours}</Description> 
<Description term="最后更新时间">{ moment(companyTraining.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = companyTraining => {
  const {CompanyTrainingBase} = GlobalComponents
  return <PermissionSetting targetObject={companyTraining}  targetObjectMeta={CompanyTrainingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class CompanyTrainingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  companyTraining = this.props.companyTraining;
    const { id,displayName, employeeCompanyTrainingCount } = companyTraining
    const cardsData = {cardsName:"公司培训",cardsFor: "companyTraining",cardsSource: companyTraining,
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
  companyTraining: state._companyTraining,
}))(Form.create()(CompanyTrainingPermission))

