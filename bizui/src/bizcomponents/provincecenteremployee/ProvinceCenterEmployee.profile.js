

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ProvinceCenterEmployee.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


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



class ProvinceCenterEmployeeProfile extends Component {

  
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
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  provinceCenterEmployee: state._provinceCenterEmployee,
}))(Form.create()(ProvinceCenterEmployeeProfile))

