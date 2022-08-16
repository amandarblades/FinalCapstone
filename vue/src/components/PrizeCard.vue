<template>
  <div class="prize-card">
      <div class="container">
          <div class="prize-name" id="prizeName">{{prize.prizeName}}</div>
          <div class="start-date" id="startDate">{{prize.startDate}}</div>
          <div class="end-date" id="endDate">{{prize.endDate}}</div>
          <div class="max-prize" id="maxPrize">{{prize.maxPrize}}</div>
          <div class="milestone" id="milestone">{{prize.milestone}}</div>
          <div class="description" id="description">{{prize.description}}</div>
          <div class="user-role" id="userRole">{{prize.userRole}}</div>
          <div class="number-of-prize-winners" id="numberOfPrizeWinners">{{prize.numberOfPrizeWinners}}</div>
          <div class="is-Active" id="isActive">{{prize.isActive}}</div>

      </div>
  </div>
</template>

<script>
export default {
    name: 'prize-card',
    props: {
        prize: Object
    }

}
</script>

<style>

</style>